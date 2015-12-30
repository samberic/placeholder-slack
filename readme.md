#Placeholder-slack: A slack slash command to fill your everyday Nic Cage needs

##What is it?
Placeholder-slack adds the command "/cage" to your slack team.  This will give you a lovely image of Nic Cage.

"/cage" or "/cage calm" will give you a picture of Nic looking calm.  
"/cage crazy" will give you a crazy image of Nic.  
"/cage gray" will give you a black and white picture of Nic.    
"/cage gif" will give you a gif of Nic Cage.  

Images will be between 300-400px tall, and 200-400px wide.

![placeholder-slack](http://i.imgur.com/WGtQJ9R.png)

##Why?
I wanted to play with the Slack API to see what it was like for an article.  
Nic Cage is awesome.
There's already a restful source of cage images over at https://www.placecage.com/, made by [@davecowart](http://www.twitter.com/davecowart).  This is basically
just an adapter to that.

##How?
Uses SparkJava to fire up a rest service. I'm hosting it on heroku. You can host your own instance easy enough, but feel free
to jump on mine (I'll try to keep downtime to a minimum).

Mine is at http://placeholder-slack.herokuapp.com/cage.

###To get Placeholder-slack on your slack
- Head to https://api.slack.com/custom-integrations and click on "Set up a slash command" just over half way down the page.
- In "Choose a command" put /cage
- On the next page, put in "http://placeholder-slack.herokuapp.com/cage" or wherever the URL is you're hosting is.
- That's it! Feel free to change your icon, description etc. to suit your needs.

##Why can't you make it a slack app I can install in one click?
Needs HTTPS. HTTPS is pricey on Heroku.  

##I want support for Bill Murray/Steven Segal/Others! OR I've found a bug OR I want to say hi/thanks!
Pull requests are welcome, or feel free to tweet me up at [@SambaHK](http://www.twitter.com/sambahk) and I'll see what I can do.
I do want to expand it past just Nic, hence why there's no cage in the project name.
 