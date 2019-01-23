import { Component, OnInit } from '@angular/core';
import gql from 'graphql-tag';
import {Apollo} from 'apollo-angular';
import {Observable} from 'rxjs';
import { map, filter, switchMap } from 'rxjs/operators'
const GET_PEOPLE = gql('{people {id, givenName, surName}}');
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent implements OnInit {
  title = 'ngfs-ui-graphql';
  people: Observable<any>;
  constructor(private apollo: Apollo) {}
  ngOnInit() {
    let self = this;
    this.people = this.apollo.watchQuery({query:GET_PEOPLE})
      .valueChanges.pipe(map(result => result.data && result.data.people));
  }
}
