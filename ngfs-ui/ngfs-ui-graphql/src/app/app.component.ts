import { Component, OnInit } from '@angular/core';
import gql from 'graphql-tag';
import {Apollo} from 'apollo-angular';
import {Observable} from 'rxjs';
import { map, filter, switchMap } from 'rxjs/operators';
import {Person} from './person';
const GET_PEOPLE = gql('{people {id, givenName, surName}}');
const CREATE_PERSON = gql`
mutation PersonCreateMutation($pi: PersonInput) {
createPerson(personInput: $pi) {
  id, givenName, surName
}
}
`;

const UPDATE_PERSON = gql`
mutation PersonUpdateMutation($pi: PersonInput) {
updatePerson(personInput: $pi) {
  id, givenName, surName
}
}
`;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent implements OnInit {
  title = 'NGFS GraphQL Example';
  people: Observable<Array<Person>>;
  selectedPerson: Person;
  constructor(private apollo: Apollo) {}
  ngOnInit() {
    let self = this;
    this.people = this.apollo.watchQuery({query:GET_PEOPLE})
      .valueChanges.pipe(map(result => result.data && result.data.people));
  };

  selectPerson(person) {
    this.selectedPerson = person;
  };

  savePerson() {
    // Save the person
    let person = this.selectedPerson;
    if(person.id) {
      this.apollo.mutate ({
        mutation: UPDATE_PERSON,
        variables: {
          pi:  {
            id: person.id,
            givenName: person.givenName,
            surName: person.surName
          }
        }
      }).subscribe(({ data }) => {
        console.log('got data', data);
        this.selectedPerson = data.updatePerson;
      },(error) => {
        console.log('there was an error sending the query', error);
      });
    } else {
      // New person
      this.apollo.mutate ({
        mutation: CREATE_PERSON,
        variables: {
          pi:  {
            givenName: person.givenName,
            surName: person.surName
          }
        }
      }).subscribe(({ data }) => {
        console.log('got data', data);
        this.selectedPerson = data.createPerson;
        this.people.push(this.selectedPerson);
      },(error) => {
        console.log('there was an error sending the query', error);
      });
    }
  };

  newPerson() {
    this.selectedPerson = new Person();
  }

}
