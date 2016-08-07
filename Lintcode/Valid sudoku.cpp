class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int r_len = board.size();
        if(r_len == 0) return true;
        int c_len = board[0].size();
        if(r_len != c_len) return false;
        if( r_len != 9) return false;
        
        for(int j=0; j < 9 ; j++) {
                        int n_c_mask = 0;

            for(int i = 0; i<9; i++){
                  if(board[i][j] != '.')
                {
                    if(n_c_mask & (1<<(board[i][j] - '1'))) return false;
                     n_c_mask  = n_c_mask | (1 << (board[i][j] -'1'));
                }
            }
        }
        
        for(int i = 0; i<9; i++) {
            int n_r_mask = 0;
            for(int j = 0; j<9; j++){
                if(board[i][j] != '.')
                {
                    if(n_r_mask & (1<<(board[i][j] - '1'))) return false;
                     n_r_mask  = n_r_mask | ( 1 << (board[i][j] -'1'));

                }

            }
        }
        
        for(int i = 0 ;i<3; i++) {
            for(int j = 0; j<3; j++) {
                 int n_m_mask = 0;
                for(int k = i*3; k < ((i*3)+3) ; k++) {
                    for(int h = j*3; h < ((j*3)+3); h++){
                         if(board[k][h] != '.' && board[k][h] != '0' )
                {
                    if(n_m_mask & (1<<(board[k][h] - '1'))) return false;
                     n_m_mask  = n_m_mask | (1 << (board[k][h] -'1'));

                }
                    }
                }
            }
        }
        
        return true;
    }
};
