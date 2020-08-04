# To Do App
This is a project to showcase architectural patterns: clean-architecture + mvvm to developing Android apps.
Separation of concerns, high level of abstraction and the dependency rule, which in our case means that layers only know about what's directly underneath them:

* Presentation layer knows about use cases (domain layer).
* Domain layer knows about repository (data layer) but not the Presentation layer.
* Data layer doesn't know about domain or presentation layers.

This allows for easier testing and maintenance and recommended for bigger projects (alongside modularization).
<img align="right" src="https://github.com/googlesamples/android-architecture/wiki/images/todoapp.gif" alt="A demo illustraating the UI of the app" width="288" height="512" style="display: inline; float: right"/>

## Applied topics:
* Kotlin Coroutines for background operations
* Koin as dependency injection
* A single-activity architecture, using the Navigation component to manage fragment operations
* A presentation layer that contains a fragment (View) and a ViewModel per screen (or feature).
* Reactive UIs using LiveData observables and Data Binding.
* A data layer with a repository and two data sources (local using Room and remote) that are queried with one-shot operations (no listeners or data streams).
