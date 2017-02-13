# Contributing

## Join us

This guide is to help you get started and get in touch with us, if needed.

The main communication channel is our
[slack team](https://rlearnprograming.slack.com/shared_invite/MTM5NzQwOTU5MjY5LTE0ODY2OTQ4NjYtZDE0MGU4ZTY0NA).

Use
[trello](https://trello.com/invite/b/HZQ5RPer/36b3a64b8c2cc299f1088f547a62f60d/kanban)
to track our work. You will have to be in the slack room before you are able to be added to the trello board.


## Coding standard

This project follows the
[Google Java coding standard](https://google.github.io/styleguide/javaguide.html).
Please make sure you read, understand and follow the coding standard before
contributing.

## Getting started
(For new Developers!)

First things first, the most important tool that you will need is git.  
Git is what we use to manage "Version Control"; in other words it's what we use to make
sure that we are all working on the same code base.
You can find a great tutorial on how to use git [here](https://www.youtube.com/watch?v=HVsySz-h9r4).  
However, if you're not comfortable with using any kind of terminal, check out [this](https://www.youtube.com/watch?v=UD7PV8auGLg) tutorial on source tree.
Which is the GUI (Graphical User Interface) equivalent of git.


Next you will want to get familiar with Java, which is the language we are using to build this project.
You can check out Oracle's [official documentation](https://docs.oracle.com/javase/7/docs/api/), or
you can check out this [video tutorial](https://thenewboston.com/videos.php?cat=31).   
If you wish to do GUI work on the project,
check out [this tutorial](https://www.youtube.com/watch?v=FLkOX4Eez6o&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG) to learn about JavaFX.

Our project will be using the [MVC](https://www.youtube.com/watch?v=1IsL6g2ixak) application structure. MVC stands for Model, View, Controller, and it represents how our code base will interact with each other. The View is the User interface, the model is the database, and the controller is what helps the view, and model interact with each other.
You can watch the video linked above to learn more about MVC.

The development process we will be using for this project is called Scrum. Scrum is all about dividing the project into little bit-size pieces, so that the project can be tested as it is being built, instead of after it has been built. To get more information about scrum, watch this quick 7 minute [video](https://www.youtube.com/watch?v=9TycLR0TqFA) about the scrum development process. 



## Sharing your work

We use git to share our code.

On our github repository, there is the ```master``` branch. That's the
stable version of the code (it represents the last published, working version).

Also, there is the ```development``` branch. That's the branch where we develop
our code and test it until it is ready to be deployed to our users, case in
which the development branch will be merged to master.

In order to contribute, create a new branch *from development* and commit your
work on the new branch. Then, push your changes and create a merge request to
development. Your code will then be reviewed and merged. Please create a
branch for each new feature.

Branches that fix a bug in the previous version of the application (bugfix
branches) and changes to the documentation that concern the previous version
of the code should be merged to both development and master.

Name your branches sensibly.

When merging 2 branches, never fast forward (```git merge --no-ff```) such that
at every merge, a merge commit is created.
