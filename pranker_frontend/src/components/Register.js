import React from 'react'
import { Button, Modal, Form, Row, Col } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';



export default function Register() {
    
    const navigate = useNavigate();
function handleSubmit() {
    navigate.push("/landing")
}
  

  return (
    <div>
        <Form className='registerForm' onSubmit={handleSubmit}>
            <Row>    
                <Form.Group as={Col} sm={6} className="mb-2 " controlId="formBasicInfo">
                    <Form.Label column>First Name</Form.Label>
                    <Form.Control size="sm" type="text" placeholder="Enter First Name" />
                    <Form.Text className="text-muted">
                    </Form.Text>
                </Form.Group>
                <Form.Group as={Col} sm={6} className="mb-2 " controlId="formBasicInfo">
                    <Form.Label column>Last Name</Form.Label>
                    <Form.Control size="sm" type="text" placeholder="Enter Last Name" />
                    <Form.Text className="text-muted">
                    </Form.Text>
                </Form.Group>
               
            </Row>
            <Form.Group className="mb-2" controlId="formBasicEmail">
                <Form.Label>Email address</Form.Label>
                <Form.Control size="sm" type="email" placeholder="Enter email" />
                <Form.Text className="text-muted">
                </Form.Text>
            </Form.Group>
            <Form.Group className="mb-2" controlId="formUsername">
                <Form.Label>Username</Form.Label>
                <Form.Control size="sm" type="email" placeholder="Enter Username" />
                <Form.Text className="text-muted">
                </Form.Text>
            </Form.Group>
            
            <Form.Group className="mb-2" controlId="formBasicPassword">
                <Form.Label column>Password</Form.Label>
                <Form.Control size="sm" type="password" placeholder="Password" />
            </Form.Group>
            <Form.Group className="mb-2" controlId="formBasicPassword">
                <Form.Label>Confirm Password</Form.Label>
                <Form.Control size="sm" type="password" placeholder="Password" />
            </Form.Group>
            <Form.Group className="mb-2" controlId="formBasicCheckbox">
                <Form.Check type="checkbox" label="Subscribe to Mailing list" />
            </Form.Group>
            <Button variant="primary" type="submit" >
                Submit
            </Button>
        </Form>
        <button onClick={handleSubmit}>go home</button>
    </div>
  )
}
