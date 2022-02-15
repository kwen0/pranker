import { Button, Modal, Form } from 'react-bootstrap';
import { useState } from 'react';

function PodcastModal(show_modal, podcast) {
    const [setShow] = useState(show_modal);
    const [show] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    return (
        <Modal show={show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>{podcast.name} {podcast.episodeTitle}</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form>
                    <Form.Group className="mb-3" controlId="formPodcastName">
                        <Form.Label>{podcast.name} {podcast.episodeTitle}</Form.Label>
                        <Form.Control type="text" placeholder="Enter podcast title" />
                    </Form.Group>
                </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose}>
                    Close
                </Button>
            </Modal.Footer>
        </Modal>
    );
}

export default PodcastModal;