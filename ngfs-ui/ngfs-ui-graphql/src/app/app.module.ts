import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";
import { Apollo, ApolloModule, APOLLO_OPTIONS } from "apollo-angular";
import { HttpLinkModule, HttpLink } from "apollo-angular-link-http";
import { InMemoryCache } from "apollo-cache-inmemory";
import { split } from 'apollo-link';
import { WebSocketLink } from 'apollo-link-ws';
import { getMainDefinition } from 'apollo-utilities';
import {
  MatButtonModule,
  MatCheckboxModule,
  MatCardModule,
  MatListModule,
  MatTableModule,
  MatRadioModule,
  MatFormFieldModule,
  MatInputModule} from '@angular/material';
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    ApolloModule,
    HttpLinkModule,
    FormsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatCardModule,
    MatListModule,
    MatTableModule,
    MatRadioModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [
    /*{
    provide: APOLLO_OPTIONS,
    useFactory(httpLink: HttpLink) {
      return {
        cache: new InMemoryCache(),
        link: httpLink.create({
          uri: "http://localhost:8530/graphql"
        })
      }
    },
    deps: [HttpLink]
  }*/
],
  bootstrap: [AppComponent]
})
export  class AppModule {
  constructor(
      apollo: Apollo,
      httpLink: HttpLink
    ) {
      // Create an http link:
      const http = httpLink.create({
        uri: 'http://localhost:8530/graphql'
      });

      // Create a WebSocket link:
      const ws = new WebSocketLink({
        uri: 'ws://localhost:8530/graphql',
        options: {
          reconnect: true
        }
      });

      // using the ability to split links, you can send data to each link
      // depending on what kind of operation is being sent
      const link = split(
        // split based on operation type
        ({ query }) => {
          const { kind, operation } = getMainDefinition(query);
          return kind === 'OperationDefinition' && operation === 'subscription';
        },
        ws,
        http,
      );

      apollo.create({
      link,
      cache: new InMemoryCache()
      });
    }

};
