import React, { useState } from 'react';
import './Quest.css';
import ModalForm from '../../Modal';
import { get } from 'lodash';
import { quests } from '../../../constants';
import img4 from '../../../images/image4.png';
import img5 from '../../../images/image5.jpg';
import img6 from '../../../images/image6.jpg';

function Quest() {
  const [correct, setCorrect] = useState(true);
  const [modal, setModal] = useState(false);

  const description = get(quests, 'quest1.description', '');

  const activeModal = () => {
    setModal(!modal);
  };

  return (
    <div className="d-flex flex-row quest-main">
      <ModalForm
        activeModal={activeModal}
        modal={modal}
        description={description}
        correct={correct}
      />

      <div className="col-8 quest-main__task">
        <div>
          <img src={img4} alt="..." className="quest-main-img" />
        </div>

        <div className="quest-info">Оберіть світлофор для пішохода</div>
      </div>

      <div className="col-4 variant">
        <img
          src={img5}
          alt="..."
          className="quest-second-img"
          onClick={() => {
            activeModal();
            setCorrect(false);
          }}
        />
        <img
          src={img6}
          alt="..."
          className="quest-second-img"
          onClick={() => {
            activeModal();
            setCorrect(true);
          }}
        />
      </div>
    </div>
  );
}

export default Quest;
