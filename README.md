# Personify Python branch
This is an experimental branch for creating a Python web application for Personify instead of Android.Please refer to the master branch's README for the real documentation.

## Dependencies
* cherrypy
* jinja2
* pyechonest
* pyen

## Setup

Make sure pip is installed

    sudo apt-get install python-pip
    
Install packages

    sudo pip install pyechonest cherrypy jinja2 pylast spotipy pyen
    
## Running

    cd personify/src
    export PYTHONPATH=$PWD:$PYTHONPATH
    cd personify
    ./server.py
