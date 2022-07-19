import React from 'react';
import { Outlet } from 'react-router-dom';

import Header from '../Header/Header';

const Layout = function () {
  return (
    <div>
      <Header />
      <main>
        <Outlet />
      </main>
    </div>
  );
};

export default Layout;
