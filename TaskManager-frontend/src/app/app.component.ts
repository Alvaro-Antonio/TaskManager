import { Component } from '@angular/core';
import { AppbarComponent } from "./appbar/appbar.component";

@Component({
  selector: 'app-root',
  imports: [AppbarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'TaskManager-frontend';
}
