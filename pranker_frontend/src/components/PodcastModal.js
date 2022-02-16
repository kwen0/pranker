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

        console.log("handleClose called: " + this.props.show_modal);

        this.setState({show: !this.props.show_modal});
        // this.state.onClose(this.props.podcast)

    }

    render() {
        if (this.props.podcast) {
            console.log("podcast modal id: " + this.props.podcast.id);
        }
        console.log("the show value is: " + this.props.show_modal);

        return (
            <Modal show={this.props.show_modal} onHide={this.handleClose}>
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