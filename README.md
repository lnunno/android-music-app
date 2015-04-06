# Personify
<a href="https://github.com/lnunno/personify/blob/master/images/web_hi_res_512.png"><img src="https://github.com/lnunno/personify/blob/master/images/web_hi_res_512.png" width="128" height="128"></a>

Prototype music discovery application for Android. Uses the Echo Nest java API along with Google Guava.

[The app is currently deployed on Amazon Web Services here. Click here to visit the app.](http://54.174.47.14:8081/)

**Update:** See the python branch for the web app. **The Android branch is no longer in active development, please see the python branch for the actual application.**

## Description
Love music? Love being up to date? Personify helps you stay up to date with the latest happenings involving your favorite artists. It also helps you learn the rich history behind your favorite music acts. Learn about where your favorite artists came from to give you an idea of where they’re going. Includes biographies, news, and blogs about the artists you love to keep you up to date when something new hits.

## Proposed features

Key:
* ~~Implemented~~
* *Nice to have, but not essential*

### Core features
1. ~~Interacts with the Echo Nest API.~~
3. ~~Has a list of artists. (Top 20 artists)~~
  1. ~~Selecting an artist goes to the artist overview.~~
4. ~~Can search for artists.~~
  1. ~~Search uses text entered by the user.~~
  2. ~~Results show most relevant artists based on the user's query.~~
5. Artist features (Artist overview):
  1. ~~List of artist biographies.~~
  2. ~~List of artist news.~~
     1. ~~Shows the date the news article was published.~~
     2. ~~Has a link to the site with the news article.~~
  3. ~~List of artist blogs.~~
      1. ~~Shows date the blog was published.~~
      2. ~~Has a link to the original blog.~~
  3. ~~Contains artist hotttnesss score.~~
  4. ~~Contains artist familiarity score.~~
  3. *List of artist events.*
  4. *Shows artist photos.*
    1. ~~One photo~~
    2. *Multiple photos*.
  5. ~~*Has a link to the artist’s official twitter (if exists).*~~
  6. ~~*Has a list of similar artists.*~~
6. ~~*Has a list of genres.*~~
  1. ~~*Selecting a genre lists top artists for that genre.*~~
  2. ~~*Genre list is paginated and the user can go forward/back pages.*~~
7. ~~*Can search for genres.*~~

### Extra features (Probably not in release v 1.0)
1. Spotify integration
  1. Users can link their Spotify accounts.
  2. Syncs saved/followed artists across Personify and Spotify.
  3. Can play top songs from an artist through Spotify.
2. Last.fm integration
  1. Users can link their Last.fm accounts.
  2. Users see number of scrobbles for the artist when they go to the artist page.

## Interface design proposal
**Note:** The final product will differ, these are initial interface ideas and sketches using the draw.io mockup tool.

### Artist view
Main information view with tabbed interface for displaying multiple items per artist.

<a href="https://github.com/lnunno/personify/blob/master/images/Artist-View.png"><img src="https://github.com/lnunno/personify/blob/master/images/Artist-View.png" width="216" height="384"></a>

### Search and navigation screen
Uses hamburger menu with a search list item and links to other views within the app.

<a href="https://github.com/lnunno/personify/blob/master/images/Hamburger-Menu.png"><img src="https://github.com/lnunno/personify/blob/master/images/Hamburger-Menu.png" width="216" height="384"></a>

## Screenshots of similar apps
Spotify is somewhat of a related app. I like their interface, but their artist biographies and (lack of) news sections could be a lot better. I am also including a screenshot from Google Music for comparison.

<a href="https://github.com/lnunno/personify/blob/master/images/app_screenshots/Screenshot_2015-02-08-19-49-24.png"><img src="https://github.com/lnunno/personify/blob/master/images/app_screenshots/Screenshot_2015-02-08-19-49-24.png" width="216" height="384"></a> 
<a href="https://github.com/lnunno/personify/blob/master/images/app_screenshots/Screenshot_2015-02-08-19-49-37.png"><img src="https://github.com/lnunno/personify/blob/master/images/app_screenshots/Screenshot_2015-02-08-19-49-37.png" width="216" height="384"></a> 
<a href="https://github.com/lnunno/personify/blob/master/images/app_screenshots/Screenshot_2015-02-08-19-50-53.png"><img src="https://github.com/lnunno/personify/blob/master/images/app_screenshots/Screenshot_2015-02-08-19-50-53.png" width="216" height="384"></a> 
<a href="https://github.com/lnunno/personify/blob/master/images/app_screenshots/Screenshot_2015-02-08-19-51-22.png"><img src="https://github.com/lnunno/personify/blob/master/images/app_screenshots/Screenshot_2015-02-08-19-51-22.png" width="216" height="384"></a> 
<a href="https://github.com/lnunno/personify/blob/master/images/app_screenshots/Screenshot_2015-02-08-19-51-32.png"><img src="https://github.com/lnunno/personify/blob/master/images/app_screenshots/Screenshot_2015-02-08-19-51-32.png" width="216" height="384"></a>
