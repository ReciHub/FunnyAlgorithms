import React from 'react';
import ReactDOM from 'react-dom';

'use strict';

// this little program uses React to spit out random quotes from the array below.
// hopefully more people decide to add their own quotes and saying and can grow this! :)

// array object holding the quoter's name as well as their quote

const allQuotes = [{
          name: "CunningWeasel",
          quote: "I walk like I'm drunk, swagga like uh",
        },
        {
          name: "Damian Lillard",
          quote: "It's Dolla time"
        },
        {
          name: "Shaq",
          quote: "BBQ chicken"
        }];

// component that stores name, quote and allquotes arr
class QuoteMachine extends React.Component {
    constructor(){
        super()
        this.state = {
          name: '',
          quote: '',
          allQuotes: []
        }
        this.handleChange = this.handleChange.bind(this)
    }

// event logic behind the random quotes + name pairs
    handleChange(event){
          const randNum = Math.floor(Math.random() * allQuotes.length)
          const randQuote = allQuotes[randNum]
          // console.log(randQuote)
          this.setState({
              name: randQuote.name,
              quote: randQuote.quote
          })
    }

// render component that keeps and displays all the markup
      render() {
      return (
          <div>
              <div id="quote-box">
                  <div id="text">
                      {this.state.quote}
                  </div>
                  <br />
                  <div id="author" style={style1}>
                      {this.state.name}
                  </div>
              <br />
              <br />
              <div className="center">
                  <button id="new-quote" onClick={this.handleChange}>New quote!</button>
                  <br />
                  <br />
                  <a id="tweet-quote" href="https://www.twitter.com/intent/tweet"> Tweet quote!</a>
                </div>
              </div>
          </div>
      )
    }
  }

// a little css to make the name look a little pretty. I was lazy so didn't make aything else look nice
const style1={
  fontWeight:900,
  padding:5,
  color:'#323299',
  margin:20
}

ReactDOM.render(<QuoteMachine />, document.getElementById("root"));
