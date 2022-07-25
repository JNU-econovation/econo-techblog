import React from 'react';
import { Outlet } from 'react-router-dom';

import './css/Manager.css';
import '../components/css/Pagination.css';
import Sidebar from './components/Sidebar';

const Manager = function () {
  return (
    <div className="manager">
      <Sidebar />
      <div className="manager-outlet">
        <Outlet />
      </div>
    </div>
  );
};

export default Manager;
