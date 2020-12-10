import React, { useState } from 'react';
import './Map.css';
import ModalForm from '../../Modal';
import { get } from 'lodash';
import { quests } from '../../../constants';
import bg from '../../../images/bg.jpg';
function Map() {
  const [correct, setCorrect] = useState(true);
  const [modal, setModal] = useState(false);

  const description = get(quests, 'quest1.description', '');

  const activeModal = () => {
    setModal(!modal);
  };

  return (
      <div className="quest-main__map">
          <img src={bg} alt="..." className="quest-main-img" />
      </div>
  );
}

export default Map;
