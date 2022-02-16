import React from "react";
import { Button, ButtonGroup } from 'react-bootstrap';
import PodcastModal from './components/PodcastModal'

class PodcastList extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
          show_podcast_modal: false,
          podcast_to_show: null
        };
        // this.showPodcastModal = this.showPodcastModal.bind(this);

    }

    togglePodcastModal (podcast) {
        this.setState({
            show_podcast_modal: !this.state.show_podcast_modal,
            podcast_to_show: podcast
        });
        // console.log("the podcast clicked: " + podcast.id)
    }

    render() {
        return <div>
                <ButtonGroup vertical>
                {this.props.podcasts.map(podcast => (
                        <Button key={podcast.id} onClick={()=> this.togglePodcastModal(podcast)}>
                            {podcast.name} {podcast.episodeTitle}
                        </Button>
                    ))}
                </ButtonGroup>

                <PodcastModal 
                    // onClose={()=> this.togglePodcastModal} 
                    show_modal={this.state.show_podcast_modal} 
                    podcast={this.state.podcast_to_show}
                />
                </div>;
    }
}



export default PodcastList;