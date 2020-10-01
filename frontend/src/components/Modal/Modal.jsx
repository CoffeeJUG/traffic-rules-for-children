import React from 'react';
import './Modal.css';
import Button from 'react-bootstrap/Button';

function Modal(props) {
  return (
    <Modal
      {...props}
      size="lg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header closeButton>
        <Modal.Title id="contained-modal-title-vcenter" className="modal">
          <img
            className="modal__icon"
            src="/icons/error-icon.png"
            alt="error-icon"
          ></img>
          <p class="modal__title">Невірно</p>
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <p>
          Cras mattis consectetur purus sit amet fermentum. Cras justo odio,
          dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac
          consectetur ac, vestibulum at eros.
        </p>
      </Modal.Body>
      <Modal.Footer>
        <Button onClick={props.onHide}>Спрьувати ще раз</Button>
        <Button onClick={props.onHide}>До карти</Button>
      </Modal.Footer>
    </Modal>
  );
}

export default Modal;
