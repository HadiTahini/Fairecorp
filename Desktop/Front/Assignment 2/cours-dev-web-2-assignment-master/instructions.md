# Assignment for the lesson 2 of the Web Development course

Autumn 2022.

## Planning

- 15/09/2022 : Lesson 1 (Basic HTML+CSS)

Assignment 1 (this one), to begin during the 1st lesson.

- 22/09/2022 : Lesson 2 (HTML forms, CSS preprocessors)

It is to be submitted for the 8/10/2022 in the evening.

## Submission procedure

You can either send me your assignment via gitlab : 

- Make a new gitlab project on your favorite gitlab instance
- If you are git-savvy enough, replace the remote of the repository
with your own remote
- Otherwise, remove the `.git` folder, and initialize a new git repository
in the assignment directory, then put it online like you would do with a new
project
- Make sure I have access to your online gitlab repository (the best is to make it public)
- Send me the link, I take the last commit before the deadline date, or a specific
commit if you tell me which one.


Or you can send it to me via email :
- ZIP your project directory
- Send it to qrichaud.pro@gmail.com

## Instructions

- You need to use your work from the 1st assignment.
- Use the new assignment directory structure provided here (you can copy/paste your code
from the 1st assignment)

We are going to implement a 2nd page : the login page. You can have 2 operationnal 
links in your template. The "about" link, will point to the page you implemented
in the first assignment.

The "login" link will point to the new page you are going to make.

1. Integrate the mockup provided for the login page.
2. Refactor your existing stylesheet in SCSS, and use the `sass` command to transpile 
your SCSS code to CSS. I setup the `.gitignore` file so that you can't commit
the CSS file. That's because the CSS is a product of the compilation chain. If your 
SCSS source is correct, the CSS will be recompiled by users checking out the repository.
3. Make sure the login form sends the correct data to the server (see spec below). If 
correct, you will see a page that says ("Congrats, you succeeded to submit the correct data"). Otherwise you will get an error page.

Backend specification for the login form to work : 

The login form must send a `POST` request to the url `/register`, with the following data:

- `username=admin`
- `password=rainbow`


## Running the web server

You will need to run the small web server provided here  :

`./run.server.py`.

Python 3 is required. Check your python installation :

```
$ python3 -V
Python 3.6.9
```
