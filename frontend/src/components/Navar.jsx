import React from 'react';

function Navbar() {
  return (
    <nav className="navbar navbar-light bg-light navbar-expand">
      <a className="navbar-brand">Logo</a>
      <ul className="navbar-nav ml-auto ">
        <li className="nav-item ">
          <a className="nav-link" href="#">Карта </a>
        </li>

        <li className="nav-item">
          <a className="nav-link" href="#">Кращі гравці </a>
        </li>

        <li className="nav-item">
          <a className="nav-link" href="#">Мій профіль </a>
        </li>
      </ul>
    </nav>
  );
}

export default Navbar;
