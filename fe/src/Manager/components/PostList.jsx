/* eslint-disable */
import React, { useState } from 'react';
import Pagination from 'react-js-pagination';

import '../css/PostList.css';

const PostList = function () {
  const columns = ['게시판', '제목', '작성일', '조회', '설정'];
  const [currentPage, setCurrentPage] = useState(1);
  const [checkedList, setCheckedList] = useState([]);
  const onChange = (checked, item) => {
    if (checked) {
      setCheckedList([...checkedList, item]);
    } else if (!checked) {
      setCheckedList(checkedList.filter((el) => el !== item));
    }
  };
  const onDelete = () => {
    console.log(checkedList);
  };
  const posts = [
    {
      id: 1,
      category: 'Culture',
      title: '가나다라에코노베이션',
      date: '2022.07.18',
      looked: 21,
    },
    {
      id: 2,
      category: 'Culture',
      title: '가나다라에코노베이션',
      date: '2022.07.18',
      looked: 21,
    },
    {
      id: 3,
      category: 'Culture',
      title: '가나다라에코노베이션',
      date: '2022.07.18',
      looked: 21,
    },
    {
      id: 4,
      category: 'Culture',
      title: '가나다라에코노베이션',
      date: '2022.07.18',
      looked: 21,
    },
    {
      id: 5,
      category: 'Culture',
      title: '가나다라에코노베이션',
      date: '2022.07.18',
      looked: 21,
    },
    {
      id: 6,
      category: 'Culture',
      title: '가나다라에코노베이션',
      date: '2022.07.18',
      looked: 21,
    },
  ];
  return (
    <div className="postlist">
      <table className="postlist-table">
        <colgroup>
          <col width="12%" />
          <col width="40%" />
          <col width="20%" />
          <col width="20%" />
          <col width="8%" />
        </colgroup>
        <thead className="postlist-table__thead">
          <tr>
            {columns.map((column) => (
              <th key={column}>{column}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {posts.map(({ id, category, title, date, looked }) => (
            <tr key={id} className="postlist-table__tr">
              <td>{category}</td>
              <td>{title}</td>
              <td>{date}</td>
              <td>{looked}</td>
              <td>
                <input
                  type="checkbox"
                  name="post"
                  value={id}
                  className="postlist-table__checkbox"
                  onChange={(e) => onChange(e.target.checked, e.target.value)}
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      {posts.length < 6 ? null : (
        <Pagination
          activePage={currentPage}
          itemsCountPerPage={5}
          totalItemsCount={posts.length}
          pageRangeDisplayed={3}
          prevPageText="<"
          nextPageText=">"
          onChange={setCurrentPage}
        />
      )}
      <button
        type="button"
        onClick={onDelete}
        className="postlist-delete__button"
      >
        삭제
      </button>
    </div>
  );
};

export default PostList;
