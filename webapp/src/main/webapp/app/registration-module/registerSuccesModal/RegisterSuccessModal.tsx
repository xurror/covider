import React from 'react';
import { Button, Modal, Spinner } from 'react-bootstrap';

function RegisterSuccessModal(props) {
  return (
    <Modal
      {...props}
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', padding: '1rem'}}>
        <Spinner animation="border" role="status" >
          <span className="sr-only">Loading...</span>
        </Spinner>
      </div>

      <Modal.Footer>
        <Button onClick={props.onHide}>Close</Button>
      </Modal.Footer>
    </Modal>
  );
}

export default RegisterSuccessModal;