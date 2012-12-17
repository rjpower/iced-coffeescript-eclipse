# IcedEclipse

This project provides an editor for 
[\(iced\)](http://maxtaco.github.com/coffee-script/)[coffeescript](http://coffeescript.org/), using the 
[Xtext](http://www.eclipse.org/Xtext/) toolkit.

## Installation

* Help -> Install Software
* Add update site: http://rjpower.org/eclipse/
* Install IcedCoffeeScript

## Features

* Syntax highlighting (keywords/class variable references)
* Block outlining (indentation aware)

Actual parsing is minimal, but I plan to add support for
more of the language as time permits.

## Why?

Because I like Eclipse, despite all of it's warts.  

Yes, there is another Xtext-based Eclipse editor for Coffeescript, but it 
hasn't been maintained for quite a while and doesn't handle indentation/etc
quite correctly.

This editor focuses mainly on giving you access to lexical highlighting and 
a few "extras".

## Development

* [Install Xtext](http://www.eclipse.org/Xtext/download.html)
* Clone this repo
* From Eclipse, File -> Import -> Existing Projects into Workspace
* Start hacking!
