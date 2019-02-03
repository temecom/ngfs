import { Component, OnInit } from '@angular/core';
import gql from 'graphql-tag';
import {Apollo, QueryRef} from 'apollo-angular';
import {Observable, BehaviorSubject} from 'rxjs';
import { map, filter, switchMap } from 'rxjs/operators';
import {Person} from './person';
const GET_PEOPLE = gql('{people {id, givenName, surName}}');
const CREATE_PERSON = gql`
mutation PersonCreateMutation($pi: PersonInput) {
createPerson(person: $pi) {
  id, givenName, surName
}
}
`;

const GET_PERSON_QUERY = gql`query GetPersonQuery ($personId: UUID) {
person (personId: $personId)  {
  id, givenName, surName
  }
}
`;
const UPDATE_PERSON = gql`
mutation PersonUpdateMutation($pi: PersonInput) {
updatePerson(person: $pi) {
  id, givenName, surName
}
}
`;

const PERSON_SUBSCRIPTION=gql`subscription SubscribeToPersonChanged ($personId: UUID) {
  personChanged(id: $personId) {
     id, givenName, surName
  }
}`;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
/**
* Main entry point for application
*/
export class AppComponent implements OnInit {
  title = 'NGFS GraphQL Example';
  _people: BehaviorSubject<Person[]>;
  people: Observable<any> ;
  selectedPerson: Person;
  selectedPersonObserver: Observable<Person>;
  personQuery: QueryRef<Person>;
  constructor(private apollo: Apollo) {
    this._people = <BehaviorSubject<Person[]>>new BehaviorSubject([]);
    this.people = this._people.asObservable();
  }
  ngOnInit() {
    this.apollo.watchQuery<any>({query:GET_PEOPLE})
      .valueChanges.subscribe(({data, loading}) => this._people.next(data.people));
    this.personQuery = this.apollo.watchQuery({
      query: GET_PERSON_QUERY,
      variables: {
        personId: `$person.id`
      }
    });

  };

  selectPerson(person) {
    this.selectedPerson = person;
  };

  /**
  * Save the person using the create or update watchQuery
  */
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
        this._people.value.push(this.selectedPerson);
      },(error) => {
        console.log('there was an error sending the query', error);
      });
    }
  };

  subscribe() {
    let person = this.selectedPerson;
    if(person.id) {
      this.personQuery.subscribeToMore({
        document: PERSON_SUBSCRIPTION,
        variables: {
          personId: this.selectedPerson.id
        },
        updateQuery: (prev, {subscriptionData}) => {
          if (!subscriptionData.data) {
            return prev;
          }
          return subscriptionData.data;
        }
      });
    }

  }
  newPerson() {
    this.selectedPerson = new Person();
  }

}
