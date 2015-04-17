'''
Created on Mar 22, 2015

@author: lnunno
'''

# Artist buckets.
BIOGRAPHIES = 'biographies'
BLOGS = 'blogs'
DISCOVERY = 'discovery'
DISCOVERY_RANK = 'discovery_rank'
DOC_COUNTS = 'doc_counts'
FAMILIARITY = 'familiarity'
FAMILIARITY_RANK = 'familiarity_rank'
GENRE = 'genre'
HOTTTNESSS = 'hotttnesss'
HOTTTNESSS_RANK = 'hotttnesss_rank'
IMAGES = 'images'
ARTIST_LOCATION = 'artist_location'
NEWS = 'news'
REVIEWS = 'reviews'
SONGS = 'songs'
URLS = 'urls'
VIDEO = 'video'
YEARS_ACTIVE = 'years_active'
SPOTIFY_ID = 'id:spotify'

top_artist_buckets = [HOTTTNESSS_RANK, BIOGRAPHIES, IMAGES]
search_artist_buckets = top_artist_buckets
artist_buckets = [BIOGRAPHIES, BLOGS, GENRE, HOTTTNESSS_RANK, IMAGES, ARTIST_LOCATION, NEWS, REVIEWS, YEARS_ACTIVE, SPOTIFY_ID]

# Genre buckets
DESCRIPTION = 'description'

genre_buckets = [DESCRIPTION, URLS]
