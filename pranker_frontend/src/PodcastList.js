import React from "react";

class PodcastList extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
          podcasts: this.props.podcasts
        };
    }

    render() {
        return <div>
                <ol>
                    {this.state.podcasts.map(podcast => (
                        <li key={podcast.id}>
                            {podcast.name} {podcast.episodeTitle} {podcast.avgRating}
                        </li>
                    ))}
                </ol>
                </div>;
    }
}



export default PodcastList;