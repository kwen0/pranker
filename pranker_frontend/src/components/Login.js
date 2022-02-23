import React, { Component } from 'react'
import { useState } from 'react';
import { Button, Modal, Form } from 'react-bootstrap';


export default function Login() {
    return (
    <div>
          
        <Form className='loginForm'>
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
            <Button variant="primary" type="submit">
                Submit
            </Button>
        </Form>
    </div>

    )
}
