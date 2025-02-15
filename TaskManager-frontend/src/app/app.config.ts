import { ApplicationConfig, InjectionToken, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration, withEventReplay } from '@angular/platform-browser';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({ 
    eventCoalescing: true 
  }), provideRouter(routes), provideClientHydration(withEventReplay()), provideAnimationsAsync()]
};

export const API_URL = new InjectionToken<string>('apiUrl', {
  providedIn: 'root',
  factory: () => 'http://localhost:8080'
});
