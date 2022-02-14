import React from "react";
import PodcastList from "./PodcastList";

import AddPodcast from './components/AddPodcast';

class Landing extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
          error: null,
          isLoaded: false,
          podcasts: []
        };
    }

    componentDidMount() {
        fetch("http://localhost:8990/api/podcasts")
          .then(res => res.json())
          .then(
            (result) => {
              this.setState({
                isLoaded: true,
                podcasts: result
              });
            },
            // Note: it's important to handle errors here
            // instead of a catch() block so that we don't swallow
            // exceptions from actual bugs in components.
            (error) => {
              this.setState({
                isLoaded: true,
                error
              });
            }
          )
      }

    render() {
        const { error, isLoaded, podcasts } = this.state;
        
        if (error) {
            return <div>Error: {error.message}</div>;
        } else if (!isLoaded) {
            return <div>Loading...</div>;
        } else {
            return <div>
                <h1>Pranker</h1>
                <p>The podcast ranker app</p>

                <p>Search for a podcast title below to update the results and see specific podcast rankings!</p>
                <input type="text" placeholder="Search Podcast Title"></input>
                <PodcastList podcasts={podcasts}></PodcastList>
                <AddPodcast />
                </div>;
        }
    }
}



export default Landing;