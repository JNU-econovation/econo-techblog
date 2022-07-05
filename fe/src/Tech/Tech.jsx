import React, { useState, useEffect } from 'react';
import Pagination from 'react-js-pagination';
import './css/Tech.css';
import './css/Pagination.css';

import Banner from './components/Banner';
import Official from './components/Official';
import Recent from './components/Recent';

const Tech = function () {
  const [movies, setMovies] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const POST_PER_PAGE = 5;
  const getMovies = async () => {
    const response = await fetch(
      'https://yts.mx/api/v2/list_movies.json?minimum_rating=9&sort_by=year',
    );
    const json = await response.json();
    setMovies(json.data.movies);
  };
  useEffect(() => {
    getMovies();
  }, []);

  const indexOfLast = currentPage * POST_PER_PAGE;
  const indexOfFirst = indexOfLast - POST_PER_PAGE;
  const currentPosts = (posts) => {
    let slicePosts = 0;
    slicePosts = posts.slice(indexOfFirst, indexOfLast);
    return slicePosts;
  };
  return (
    <div className="tech">
      <Banner />
      <div className="posts">
        <div className="official-posts">
          <p>Official</p>
          <Official />
        </div>
        <div className="recent-posts">
          <p>Recent posts</p>
          {currentPosts(movies).map((item) => (
            <Recent
              key={item.id}
              id={item.id}
              title={item.title}
              summary={item.summary}
            />
          ))}
          <Pagination
            activePage={currentPage}
            itemsCountPerPage={5}
            totalItemsCount={movies.length}
            pageRangeDisplayed={3}
            prevPageText="<"
            nextPageText=">"
            onChange={setCurrentPage}
          />
        </div>
      </div>
    </div>
  );
};

export default Tech;
