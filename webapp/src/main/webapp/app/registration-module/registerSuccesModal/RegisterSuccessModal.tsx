import React from 'react';
import {Button, Modal, Spinner} from 'react-bootstrap';

function RegisterSuccessModal(props) {
  return (
    <Modal
      {...props}
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header closeButton>
      </Modal.Header>
      
      <Modal.Body>
        Successfully Registered
        <Spinner animation="border" role="status">
        <span className="sr-only">Loading...</span>
      </Spinner>
      </Modal.Body>
      <Modal.Footer>
        <Button onClick={props.onHide}>Close</Button>
      </Modal.Footer>
    </Modal>
  );
}

export default RegisterSuccessModal;