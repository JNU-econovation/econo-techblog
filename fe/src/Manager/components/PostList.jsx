/* eslint-disable object-curly-newline */
import React, { useState } from 'react';
import Pagination from 'react-js-pagination';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';
import { gql, useQuery } from '@apollo/client';

import '../css/PostList.css';

const POST_BY_USER = gql`
  query postByUser($userId: Int!) {
    postByUser(userId: $userId) {
      postId
      userName
      content
      title
      mainCategoryNumber
      categoryName
      createdDate
      views
      hearts
    }
  }
`;

const PostList = function ({ uid, onChange }) {
  const columns = ['게시판', '제목', '작성일', '조회', '설정'];
  const category = ['Tech', 'Culture', 'Trouble shooting'];
  const [currentPage, setCurrentPage] = useState(1);
  const { data, loading } = useQuery(POST_BY_USER, {
    variables: {
      userId: uid,
    },
  });

  if (loading) return null;
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
          {data.postByUser.map(
            ({ postId, mainCategoryNumber, title, createdDate, views }) => (
              <tr key={postId} className="postlist-table__tr">
                <td>{category[mainCategoryNumber - 1]}</td>
                <td>{title}</td>
                <td>{createdDate}</td>
                <td>{views}</td>
                <td>
                  <input
                    type="checkbox"
                    name="post"
                    value={postId}
                    className="postlist-table__checkbox"
                    onChange={(e) => onChange(e.target.checked, e.target.value)}
                  />
                </td>
              </tr>
            ),
          )}
        </tbody>
      </table>
      {data.postByUser.length < 7 ? null : (
        <Pagination
          activePage={currentPage}
          itemsCountPerPage={6}
          totalItemsCount={data.postByUser.length}
          pageRangeDisplayed={5}
          prevPageText="<"
          nextPageText=">"
          onChange={setCurrentPage}
        />
      )}
    </div>
  );
};

PostList.propTypes = {
  uid: PropTypes.string.isRequired,
  onChange: PropTypes.func.isRequired,
};

export default PostList;
