import React from "react";

class Landing extends React.Component {
    render() {
      return <div>
          <h1>This is Pranker</h1>
          <h3>The podcast ranker app</h3>

          <p>Search for a podcast title below to update the results and see specific podcast rankings!</p>
          <input type="text" placeholder="Search Podcast Title"></input>

          <ol>
              <li><p>podcast 1</p></li>
              <li><p>podcast 2</p></li>
              <li><p>podcast 3</p></li>
              <li><p>podcast 4</p></li>
          </ol>

          
          </div>;
    }
}



export default Landing;