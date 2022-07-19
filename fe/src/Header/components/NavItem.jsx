import React from 'react';
import { Link } from 'react-router-dom';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import './NavItem.css';

function NavItem({ navName, link }) {
  return (
    <Link to={link} className="nav-item">
      {navName}
    </Link>
  );
}

NavItem.propTypes = {
  navName: PropTypes.string.isRequired,
  link: PropTypes.string.isRequired,
};

export default NavItem;
