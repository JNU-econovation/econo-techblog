import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';
import '../css/Pagination.css';

const Pagination = function ({ postsPerPage, totalPosts, setCurrentPage }) {
  const pageNum = [];
  for (let i = 1; i <= Math.ceil(totalPosts / postsPerPage); i += 1) {
    pageNum.push(i);
  }
  return (
    <div className="pagination">
      {pageNum.map((number) => (
        <button
          key={number}
          onClick={() => setCurrentPage(number)}
          type="button"
        >
          {number}
        </button>
      ))}
    </div>
  );
};

Pagination.propTypes = {
  postsPerPage: PropTypes.number.isRequired,
  totalPosts: PropTypes.number.isRequired,
  setCurrentPage: PropTypes.func.isRequired,
};

export default Pagination;
