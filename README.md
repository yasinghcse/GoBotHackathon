# GoBotHackathon (This application is awarded as the Best Creative Project in Hackathon)
App Build In Hackathon 2017

TECHNOLOGY: JAVA, JSP, SERVLET, HTML, CSS, BOOTSTRAP, JQUERY, AJAX
            INVERTED INDEX,JSOUP, PDFBOX
            IBM WATSON CONVERSATION API, GOOGLE SHORTENER URL API, TWITTER API
             

The project is focused on integrating IBM Watson conversation service with a web crawler and search engine.

The system on startup crawl to the city of Windsor website and finds the most recent upcoming city of Windsor agenda
link dynamically. The system extracts all the words in the pdf found through the link and creates a data dictionary
using inverted index and Trie. The purpose of using this data structure is to perform searching very efficiently 
(nearly O(n) where n is the length of the searched keyword). 
Using IBM Watson conversation service, an interactive chat box is created which interacts with the user in natural language. 
User can post any query(keyword to be searched) about the agenda to the chat box and it will return all the 
relevant occurrence of the keyword in the agenda. 
If user misspelled something, suggestions are provided for the similar words in agenda. 
Selected output by the user would be posted on the twitter along the minified URL of the pdf.
