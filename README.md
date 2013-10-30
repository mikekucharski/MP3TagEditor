MP3TagEditor
============

Tired of having messed up song Metadata? This is a tool used to edit the ID3 tags of mp3 files in bulk. The data is pulled from the mp3 filename and the parent directory and stored in the ID3 tags of the files. 

## What is a valid CD directory format?

First, all of the song files of this CD must be in this directory. The artist name, album name, and year are parsed from this folder. The directory should be in the following format:

`<Artist Name> - <Album Name> (<year>)`

without the angle brackets. An example directory name: 

`Cool Artist - Awesome Demo (1993)`

## What is a valid song file format?

The song number and song name are parsed from the music file. The song number must contain 2 digits and there must be a space delimiting the song number from the name.

`<2 digit song number> <song name>.mp3`

Example:

`01 Introduction.mp3
 02 Rock And Roll.mp3
 03 Outro.mp3`

## Can I format many CD's at once?

Yes! Simple fill a directory with CD directories and check the box "Many CD's" from the GUI.

## Which file extensions are supported?

MP3 files are the only files that are supported. Hence the name "MP3 Tag Editor".

## Which ID3 tags are supported?

 + ID3v1.0
 + ID3v1.1
 + ID3v2.3.0
 
ID3v2.2 tags are not supported since that is the way JID3 was implemented.