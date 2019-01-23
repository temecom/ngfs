import { Component, OnInit } from '@angular/core';
import gql from 'graphql-tag';
import {Apollo} from 'apollo-angular';
const GET_PEOPLE = gql'{people {id, givenName, surName}}';
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
    this.people = this.apollo.watchQUery({query:GET_PEOPLE})
      .valueChanges.pipe(map(result => result.data && result.data.people));
  }
}
