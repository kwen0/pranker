import { Button, Modal, Form } from 'react-bootstrap';
import React from "react";

class PodcastModal extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
          show: props.show_modal,
        //   onClose: props.onClose,
          podcast: props.podcast
        };
        this.handleClose = this.handleClose.bind(this)
    
    }

    handleClose() {

        console.log("handleClose called with: " + this.state.show);
        this.setState({show: !this.state.show});
        // this.state.onClose(this.props.podcast)
    }

    render() {
        if (this.state.podcast) {
            console.log("podcast modal id: " + this.state.podcast.id);
        }
        console.log("the show value is: " + this.state.show);

        return (
            <Modal show={this.state.show} onHide={this.handleClose}>
                <Modal.Header closeButton>
                    {/* <Modal.Title>{podcast.name} {podcast.episodeTitle}</Modal.Title> */}
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="formPodcastName">
                            {/* <Form.Label>{podcast.name} {podcast.episodeTitle}</Form.Label> */}
                            <Form.Control type="text" placeholder="Enter podcast title" />
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={this.handleClose}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal>
        );
    }

}

export default PodcastModal;