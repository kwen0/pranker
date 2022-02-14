import React from "react";
import { Button, ButtonGroup } from 'react-bootstrap';

class PodcastList extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
          podcasts: this.props.podcasts
        };
    }

    render() {
        return <div>
                <ButtonGroup vertical>
                {this.state.podcasts.map(podcast => (
                        <Button key={podcast.id}>
                            {podcast.name} {podcast.episodeTitle}
                        </Button>
                    ))}
                </ButtonGroup>
                </div>;
    }
}



export default PodcastList;