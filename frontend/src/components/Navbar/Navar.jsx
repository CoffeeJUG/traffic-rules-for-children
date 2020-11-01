import React from 'react';
import './Navbar.css';

function Navbar() {
  return (
    <div className="header">
      <a className="header__link link" href="/">
        Logo
      </a>
      <nav className="navigation">
        <a className="navigation__link link" href="/">
          Карта
        </a>
        <a className="navigation__link link" href="/">
          Кращі гравці
        </a>
        <a className="navigation__link link" href="/">
          Мій профіль
        </a>
      </nav>
    </div>
  );
}

export default Navbar;
