import { Button, Modal, Form } from 'react-bootstrap';
import { useState } from 'react';

function AddPodcast() {
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    return (
        <div>
            <Button variant="primary" onClick={handleShow}>
                Add Podcast
            </Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Add a Podcast</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="formPodcastName">
                            <Form.Label>Podcast Title</Form.Label>
                            <Form.Control type="text" placeholder="Enter podcast title" />
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleClose}>
                        Submit
                    </Button>
                </Modal.Footer>
            </Modal>
        </div>
    );
}

export default AddPodcast;