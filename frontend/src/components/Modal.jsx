import React from 'react';
import { Button, Modal, ModalBody, ModalFooter, ModalHeader } from 'reactstrap';

const ModalForm = (props) => {
  const { description, correct, activeModal, modal } = props;

  const toggle = () => {
    activeModal();
  };

  return (
    <>
      {correct && (
        <Modal isOpen={modal} toggle={toggle} centered>
          <ModalHeader toggle={toggle}>Вірно</ModalHeader>

          <ModalBody>{description}</ModalBody>

          <ModalFooter>
            <Button color="primary" onClick={toggle}>
              Далі
            </Button>{' '}
          </ModalFooter>
        </Modal>
      )}

      {!correct && (
        <Modal isOpen={modal} toggle={toggle} centered>
          <ModalHeader toggle={toggle}>Невірно</ModalHeader>

          <ModalBody>{description}</ModalBody>

          <ModalFooter>
            <Button color="primary" onClick={toggle}>
              Спробувати ще раз
            </Button>{' '}
            <Button outline color="primary" onClick={toggle}>
              До карти
            </Button>{' '}
          </ModalFooter>
        </Modal>
      )}
    </>
  );
};

export default ModalForm;
