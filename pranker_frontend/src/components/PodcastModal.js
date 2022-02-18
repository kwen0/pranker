import { Button, Modal, Form, Image } from 'react-bootstrap';
import React from "react";
import ReactStars from 'react-stars';

class PodcastModal extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
          show: props.show_modal,
          podcast: props.podcast
        };
        this.togglePodcastModal = this.togglePodcastModal.bind(this)
    
    }

    togglePodcastModal(podcast) {
        this.setState({
            show: !this.state.show,
            podcast: podcast
        });
    }

    render() {
        if (!this.state.podcast) {
            return null
        }

        return (
            <Modal show={this.state.show} onHide={this.togglePodcastModal}>
                <Modal.Header closeButton>
                    <Modal.Title>{this.state.podcast.name} {this.state.podcast.episodeTitle}</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <h1>{this.state.podcast.name} {this.state.podcast.episodeTitle}</h1>
                    <Image src="/jre-podcast.jpg" fluid={true} roundedCircle={true}/>
                    <ReactStars count={10} size={24} color2={'#ffd700'} half={true} value={this.state.podcast.avgRating * 2}/>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={this.togglePodcastModal}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal>
        );
    }

}

export default PodcastModal;