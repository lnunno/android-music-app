'''
Created on Mar 21, 2015

@author: lnunno
'''
from pyechonest import config
from personify import secret
import pyen
from echo_nest.buckets import genre_list_buckets
from datetime import datetime

en = None

def init():
    global en
    en = pyen.Pyen(api_key=secret.ECHO_NEST_API_KEY)
    config.ECHO_NEST_API_KEY = secret.ECHO_NEST_API_KEY
    
def truncate_text(text,num_char=80):
    text = (text[:num_char] + '...') if len(text) > num_char else text
    return text

def truncate_bio(text):
    return truncate_text(text, num_char=400)

def get_artist_display_image(artist, placeholder_size=64):
    image_ls = artist.images
    if len(image_ls) == 0:
        placeholder_image = 'http://placehold.it/%d&text=No+Artist+Image+Available' % (placeholder_size)
        return placeholder_image
    return artist.images[0]['url']

def get_brief_bio(artist):
    biography_ls = artist.biographies
    if len(biography_ls) == 0:
        return ''
    bio = artist.biographies[0]
    bio_text = bio['text']
    return truncate_text(bio_text,400)

def get_genre_list():
    response = en.get('genre/list', bucket=genre_list_buckets)  
    return response['genres']

def pretty_date(date_str):
    dt = datetime.strptime(date_str, '%Y-%m-%dT%H:%M:%S')
    return dt.strftime('%a %b %d, %Y')

def pretty_score(score_num):
    score_num = score_num*100
    score_num = int(score_num)
    return '%d%%' % (score_num)
    
    
init()