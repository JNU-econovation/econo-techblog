import React, { useState } from 'react';
import Pagination from 'react-js-pagination';
import './css/Manager.css';
import '../components/css/Pagination.css';

import Sidebar from './components/Sidebar';
import Table from './components/Table';

const Manager = function () {
  const [currentPage, setCurrentPage] = useState(1);
  const userList = [
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
  ];
  return (
    <div className="manager">
      <Sidebar />
      <div className="manager-userlist">
        <h2 className="manager-userlist__title">전체 회원 관리</h2>
        <Table data={userList} />
        <Pagination
          activePage={currentPage}
          itemsCountPerPage={5}
          totalItemsCount={userList.length}
          pageRangeDisplayed={3}
          prevPageText="<"
          nextPageText=">"
          onChange={setCurrentPage}
        />
      </div>
    </div>
  );
};

export default Manager;
