import React from 'react';
import {Button, Modal, ModalBody, ModalFooter, ModalHeader} from 'reactstrap';

const ModalForm = (props) => {
  const {description, correct, activeModal, modal} = props;

  const toggle = () => {
    activeModal();
  };

  return (
    <Modal isOpen={modal} toggle={toggle} centered>
      <ModalHeader toggle={toggle}>
        {correct ? 'Вірно' : 'Невірно'}
      </ModalHeader>

      <ModalBody>{description}</ModalBody>

      <ModalFooter>
        <Button color="primary" onClick={toggle}>
          {correct ? 'Далі' : 'Спробувати ще раз'}
        </Button>{' '}

        {!correct &&
        <Button outline color="primary" href="/map" onClick={toggle}>
          До карти
        </Button>
        }
      </ModalFooter>
    </Modal>
  )
};

export default ModalForm;
