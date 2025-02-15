import { Component } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import { RouterLink,RouterOutlet,RouterLinkActive } from '@angular/router';
import { ContentComponent } from "../content/content.component";

@Component({
  selector: 'app-appbar',
  imports: [MatToolbarModule, MatButtonModule, MatIconModule, RouterOutlet, RouterLink, RouterLinkActive, ContentComponent],
  templateUrl: './appbar.component.html',
  styleUrl: './appbar.component.css'
})
export class AppbarComponent {

}
