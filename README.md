# Personify Python branch
This is an experimental branch for creating a Python web application for Personify instead of Android.
Please refer to the master branch's README for the real documentation.

## Dependencies
* cherrypy
* jinja2
* pyechonest
* pyen -- Used where pyechonest does not have API bindings (mainly genres)

## Setup

Make sure pip is installed

    sudo apt-get install python-pip
    
Install packages

    sudo pip install pyechonest cherrypy jinja2 pylast spotipy pyen
    
## Running

    cd personify/src
    export PYTHONPATH=$PWD:$PYTHONPATH
    cd personify

Create a Python source file `secret.py` and place your Echo Nest API key here as a variable named `ECHO_NEST_API_KEY`. Then run.
    
    ./server.py
