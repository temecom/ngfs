import { Component } from '@angular/core';
import {Datastore} from './core/services/data-store';
import { JsonApiModule } from 'angular2-jsonapi';
import {JsonApiQueryData} from 'angular2-jsonapi';
import {Person} from './shared/models/person';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string  = 'Demo App';
  people: Array<Person>;

 constructor(private datastore: Datastore) { }

  loadData() {
    this.datastore.findAll(Person)
      .subscribe((items : JsonApiQueryData<Person>) =>
      this.people = items.getModels());
  }
}
