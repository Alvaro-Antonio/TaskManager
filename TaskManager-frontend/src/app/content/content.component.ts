import { ChangeDetectionStrategy, Component } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import { Person } from '../models/person';
import { Departament } from '../models/departament';
import {
  CdkDragDrop,
  moveItemInArray,
  transferArrayItem,
  CdkDrag,
  CdkDropList,
} from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-content',
  imports: [CdkDropList, CdkDrag,MatCardModule],
  templateUrl: './content.component.html',
  styleUrl: './content.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ContentComponent {
  person: Person = {
    id: 1,
    name: 'John',
    departament: {
      id: 1,
      name: 'IT'
    }
  };
    
  backlog = [this.person, this.person];

  todo = [this.person, this.person, this.person];

  done = [this.person, this.person, this.person, this.person];

  drop(event: CdkDragDrop<Person[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex,
      );
    }
  }
}
