## Getting started
(For new Developers!)

First things first, the most important tool that you will need is git.
Git is what we use for version control; in other words it's what we use
to make sure that we are all working on the same code base.
You can find a great tutorial on how to use git
[here](https://www.youtube.com/watch?v=HVsySz-h9r4).
However, if you're not comfortable with using any kind of terminal, check out
[this](https://www.youtube.com/watch?v=UD7PV8auGLg) tutorial on sourcetree,
a GUI (Graphical User Interface) interface for git.

Next you will want to get familiar with Java, the programming language we are
using to build this project. You can check out Oracle's [official
documentation](https://docs.oracle.com/javase/7/docs/api/), or you can check
out this [video tutorial](https://thenewboston.com/videos.php?cat=31). If you
wish to do GUI work on the project, check out
[this tutorial](https://www.youtube.com/watch?v=FLkOX4Eez6o&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG)
to learn about JavaFX, our graphical library.

Our project will be using the
[MVC](https://www.youtube.com/watch?v=1IsL6g2ixak) design pattern/architecture.
MVC stands for Model, View, Controller, the three main components of the
application (MVC basically describes how the application should be splitted
into these 3 components and how they interact with each other). The View is the
module that deals with the user interface, the model is the business logic,
and the controller is what helps the view and the model interact with each
other. In other words, the view module draws on the screen, the model is the
clever part and the controller orchestrates everything.
You can watch the video linked above to learn more about MVC.

The development methodology we will be using for this project is called Scrum.
Scrum is all about dividing the project into little bit-size pieces, so that
the project can be tested as it is being built, instead of after it has been
built. To get more information about scrum, watch this quick 7 minute
[video](https://www.youtube.com/watch?v=9TycLR0TqFA).


### Git setup

This section will help you setup git to be able to contribute to this project.
It assumes you know the basics of git and you use a shell.

First, configure git so it knows who you are (basically to be able to "sign"
your work):

    git config --global user.name "John Doe"
    git config --global user.email "john.dee@email.com"

In git, code is stored in a repository. Since git is a distributed tool, all
repositories are the same (we'll come to this a bit later). The main repository
is on GitHub. The only reason its "main" is because we decided so, technically
it's the same as all other repositories.

Now, you need to _clone_ (copy) the _repository_ from github. There are 2 ways
of doing this: using https (easier to setup, but will ask for your github
username and password from time to time) or ssh (easier to use, but requires
a bit of setup). So, go to the main project page, copy the _clone url_ (https
or ssh - be sure to read about setting up ssh for git if you want to use it,
otherwose go with https) and type it in a terminal:

    git clone <clone_url>

This will create a subdirectory in your current directory with a repository
identical to the one on github.

Now you are ready to create branches (following the branching model described
below), create commits, have fun, except...you can't push code to the main
repository, because you don't have access.

In order to fix this, go to github and create a fork of the main repository.
A fork is basically another copy of the repository, but this one is associated
with your account, so you can push to it. So the workflow would be to push
to your fork, then do a pull request to the main repository (the pull request
is done on github).

All nice, but having a fork implies that you have another repository you have
to manage (i.e. keep up to date with the main repository). Git has a nice
feature called remotes. A remote is basically another copy of the repository
of the project you are working on. The default remote is called _origin_,
and you can confirm this by doing:

    git remote -v

For example, when you are on the dev branch and do:

    git pull

what you actually do is

    git pull origin dev

Thus, the full syntax of git push/pull is:

    git push/pull <remote> <branch>

To add a remote you simply do:

    git remote add <name> <clone_url>

Now, you can do:

    git push fork dev

to push to the dev branch of your fork (assuming you named the remote "fork")
and:

   git pull origin dev

to synchronize your *current* branch with origin's dev. If you are not on
the dev branch, it will merge the code from the origin's dev to yours, so
be careful.
